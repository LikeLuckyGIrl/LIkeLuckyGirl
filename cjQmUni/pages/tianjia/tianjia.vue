<template>
	<view>
		<view class="uni-container">
			<uni-table ref="table" :loading="loading" border stripe type="selection" emptyText="暂无更多数据"
				@selection-change="selectionChange">
				<uni-tr>
					<uni-th align="center">ID</uni-th>
					<uni-th align="center">分类</uni-th>
					<uni-th align="center">标题</uni-th>
					<uni-th align="center">正文</uni-th>
					<uni-th align="center">图片1</uni-th>
					<uni-th align="center">图片2</uni-th>
					<uni-th align="center">图片3</uni-th>
					<uni-th width="204" align="center">设置</uni-th>
				</uni-tr>
				<uni-tr v-for="(item, index) in tableData" :key="index">
					<uni-td align="center">{{ item.id }}</uni-td>
					<uni-td align="center">{{ item.classification }}</uni-td>
					<uni-td align="center">{{ item.className.slice(0, 10) }}</uni-td>
					<uni-td align="center">{{ item.particulars.slice(0, 10) }}</uni-td>
					<uni-td align="center">{{ item.urlOne.slice(0, 20) }}</uni-td>
					<uni-td align="center">{{ item.urlTwo.slice(0, 20) }}</uni-td>
					<uni-td align="center">{{ item.urlThree.slice(0, 20) }}</uni-td>
					<uni-td>
						<view class="uni-group">
							<button class="uni-button" size="mini" type="primary" @tap="puta(item)">修改</button>
							<button class="uni-button" size="mini" type="warn" @tap="DELETE(item.id)">删除</button>
						</view>
					</uni-td>
				</uni-tr>
			</uni-table>
			<view class="uni-pagination-box"><uni-pagination show-icon :page-size="pageSize" :current="pageCurrent"
					:total="total" @change="change" /></view>
		</view>
		<view class="czd">
			<uni-table>
				<uni-tr>
					<uni-th align="center">分类</uni-th>
					<uni-th align="center">标题</uni-th>
					<uni-th align="center">正文</uni-th>
					<uni-th align="center">图片1</uni-th>
					<uni-th align="center">图片2</uni-th>
					<uni-th align="center">图片3</uni-th>
					<uni-th align="center">设置</uni-th>
				</uni-tr>
				<uni-tr>
					<uni-td align="center"><input v-model="posta.classification" type="text" name="classification"
							id="classification"></input></uni-td>
					<uni-td align="center"><input v-model="posta.className" type="text" name="className"
							id="className"></input></uni-td>
					<uni-td align="center"><input v-model="posta.particulars" type="text" name="particulars"
							id="particulars"></input></uni-td>
					<uni-td align="center"><input v-model="posta.urlOne" type="text" name="urlOne"
							id="urlOne"></input></uni-td>
					<uni-td align="center"><input v-model="posta.urlTwo" type="text" name="urlTwo"
							id="urlTwo"></input></uni-td>
					<uni-td align="center"><input v-model="posta.urlThree" type="text" name="urlThree"
							id="urlThree"></input></uni-td>
					<uni-td align="center"><button class="uni-button" size="mini" type="primary"
							@click="postb()">添加</button></uni-td>
				</uni-tr>
			</uni-table>
		</view>

		<view v-if="isModalVisible" class="modal">
			<view class="modal-content">
				<text class="title">修改信息</text>
				<form @submit.prevent="submitForm">
					<!-- 在此处添加您的表单字段 -->
					<view class="form-item">
						<text class="label">分类:</text>
						<input type="text" v-model="formData.classification">
					</view>
					<view class="form-item">
						<text class="label">标题:</text>
						<input type="email" v-model="formData.className">
					</view>
					<view class="form-item">
						<text class="label">正文:</text>
						<input type="email" v-model="formData.particulars">
					</view>
					<view class="form-item">
						<text class="label">图片1:</text>
						<input type="email" v-model="formData.urlOne">
					</view>
					<view class="form-item">
						<text class="label">图片2:</text>
						<input type="email" v-model="formData.urlTwo">
					</view>
					<view class="form-item">
						<text class="label">图片3:</text>
						<input type="email" v-model="formData.urlThree">
					</view>
					<button type="submit" @click="submitForm()">提交</button>
					<button @click="hideModal()">关闭</button>
				</form>
			</view>
		</view>


	</view>
</template>

<script>
	import {
		post,
		selectByPage,
		deleteid,
		put
	} from '../../common/api'
	export default {
		data() {
			return {
				luan: [],
				searchVal: '',
				tableData: [],
				// 每页数据量
				pageSize: 10,
				// 当前页
				pageCurrent: 1,
				// 数据总量
				total: 0,
				loading: false,
				posta: {
					id: 0,
					classification: '',
					className: '',
					particulars: '',
					urlOne: '',
					urlTwo: '',
					urlThree: ''
				},

				isModalVisible: false,
				formData: {
					id: 0,
					classification: '',
					className: '',
					particulars: '',
					urlOne: '',
					urlTwo: '',
					urlThree: ''
				}

			}
		},
		onLoad() {
			this.selectedIndexs = []
			this.getData(this.pageCurrent)
		},
		methods: {
			// 多选处理
			selectedItems() {
				return this.selectedIndexs.map(i => this.tableData[i])
			},
			// 多选
			selectionChange(e) {
				console.log(e.detail.index)
				this.selectedIndexs = e.detail.index
			},
			//批量删除
			delTable() {
				console.log(this.selectedItems())
			},
			// 分页触发
			change(e) {
				this.$refs.table.clearSelection()
				this.selectedIndexs.length = 0
				this.getData(e.current)
			},
			// 搜索
			search() {
				this.getData(1, this.searchVal)
			},
			DELETE(id) {
				deleteid(id)
				this.getData(this.luan.current)
			},
			postb() {
				console.log(this.posta)
				post('post', this.posta)
				this.getData(this.luan.current)
			},
			getData(pageCurrent) {
				setTimeout(() => {
					selectByPage(pageCurrent).then((res) => {
						console.log(res)
						this.luan = res[1].data
						this.tableData = res[1].data.records
						this.total = res[1].data.total
					})
				}, 500)
			},
			puta(item) {
				this.isModalVisible = true
				this.formData = item
			},
			hideModal() {
				this.isModalVisible = false
			},
			submitForm() {
				var cad = this.formData
				let aa = 'put'
				console.log(this.formData)
				console.log("99999999999")
				post(aa, cad)
				this.hideModal();
				uni.showToast({
					title: '表单已提交！',
					icon: 'success'
				})
				this.getData(this.luan.current)
			}
		}
	}
</script>

<style>
	.czd uni-table uni-tr uni-td input {
		border: solid 4rpx #7e7e7e;
		background-color: #ccc;
		border-radius: 50rpx;
		padding: 0 20rpx;
	}

	.form-item input {
		border: solid 4rpx #7e7e7e;
		background-color: #ccc;
		border-radius: 50rpx;
		padding: 0 20rpx;
	}

	/* #ifndef H5 */
	/* page {
		padding-top: 85px;
	} */
	/* #endif */
	.uni-group {
		display: flex;
		align-items: center;
	}

	input {
		border: solid 4rpx #7e7e7e;
		background-color: #ccc;
		border-radius: 50rpx;
		padding: 0 20rpx;
	}

	/* 样式调整 */

	/* 设置按钮样式 */
	.uni-button {
		padding: 5px 10px;
		/* 调整按钮内边距 */
		border-radius: 5px;
		/* 圆角 */
		background-color: #007bff;
		/* 背景颜色 */
		color: #fff;
		/* 文字颜色 */
		border: none;
		/* 去除边框 */
		cursor: pointer;
		/* 鼠标悬停样式 */
	}

	.uni-button:hover {
		background-color: #0056b3;
		/* 悬停时的背景颜色 */
	}

	/* 删除按钮样式 */
	.uni-button[type="warn"] {
		background-color: #dc3545;
		/* 背景颜色 */
	}

	.uni-button[type="warn"]:hover {
		background-color: #c82333;
		/* 悬停时的背景颜色 */
	}

	/* 输入框样式 */
	input[type="text"],
	input[type="email"] {
		width: 100%;
		/* 输入框宽度 */
		padding: 8px;
		/* 内边距 */
		border: 1px solid #ccc;
		/* 边框 */
		border-radius: 4px;
		/* 圆角 */
		box-sizing: border-box;
		/* 盒模型 */
	}

	/* 模态框样式 */
	.modal {
		position: fixed;
		top: 0;
		left: 0;
		width: 100%;
		height: 100%;
		background-color: rgba(0, 0, 0, 0.5);
		/* 半透明背景 */
		display: flex;
		justify-content: center;
		align-items: center;
	}

	.modal-content {
		background-color: #fff;
		/* 模态框背景色 */
		padding: 20px;
		border-radius: 5px;
	}

	.close {
		position: absolute;
		top: 10px;
		right: 10px;
		cursor: pointer;
	}
</style>