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
					<uni-td align="center">{{ item.classname.slice(0, 10) }}</uni-td>
					<uni-td align="center">{{ item.particulars.slice(0, 10) }}</uni-td>
					<uni-td align="center">{{ item.url1.slice(0, 20) }}</uni-td>
					<uni-td align="center">{{ item.url2.slice(0, 20) }}</uni-td>
					<uni-td align="center">{{ item.url3.slice(0, 20) }}</uni-td>
					<uni-td>
						<view class="uni-group">
							<button class="uni-button" size="mini" type="primary">修改</button>
							<button class="uni-button" size="mini" type="warn" @tap="DELETE(item.id)">删除</button>
						</view>
					</uni-td>
				</uni-tr>
			</uni-table>
			<view class="uni-pagination-box"><uni-pagination show-icon :page-size="pageSize" :current="pageCurrent"
					:total="total" @change="change" /></view>
		</view>
		<view class="">
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
					<uni-td align="center"><input v-model="posta.classification" type="text" name="" id=""></input></uni-td>
					<uni-td align="center"><input v-model="posta.classname" type="text" name="" id=""></input></uni-td>
					<uni-td align="center"><input v-model="posta.particulars" type="text" name="" id=""></input></uni-td>
					<uni-td align="center"><input v-model="posta.url1" type="text" name="" id=""></input></uni-td>
					<uni-td align="center"><input v-model="posta.url2" type="text" name="" id=""></input></uni-td>
					<uni-td align="center"><input v-model="posta.url3" type="text" name="" id=""></input></uni-td>
					<uni-td align="center"><button class="uni-button" size="mini" type="primary" @click="postb()">添加</button></uni-td>
				</uni-tr>
			</uni-table>
		</view>
	</view>
</template>

<script>
	import {
		post,
		selectAll,
		deleteid
	} from '../../common/api'
	export default {
		data() {
			return {
				searchVal: '',
				tableData: [],
				// 每页数据量
				pageSize: 10,
				// 当前页
				pageCurrent: 1,
				// 数据总量
				total: 0,
				loading: false,
				posta:{
					id:0,
					classification:'',
					classname:'',
					particulars:'',
					url1:'',
					url2:'',
					url3:''
				}
			}
		},
		onLoad() {
			this.selectedIndexs = []
			selectAll().then((res) => {
				this.tableData = res[1].data
			})
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
				console.log(id)
				deleteid(id)
			},
			postb(){
				console.log(this.posta)
				post(this.posta.classification,this.posta.particulars,this.posta.url1,this.posta.url2,this.posta.url3,this.posta.classname)
			}
			

		}
	}
</script>

<style>
	/* #ifndef H5 */
	/* page {
	padding-top: 85px;
} */
	/* #endif */
	.uni-group {
		display: flex;
		align-items: center;
	}
	input{
		background-color: aqua;
	}
</style>