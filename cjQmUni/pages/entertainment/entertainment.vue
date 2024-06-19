<template>
    <view>
		<view class="" style="background-color: #dfdfdf; border: solid black 4rpx; margin: 0 auto; width: 80%; border-radius: 50rpx;">
			<input type="text" @input="sousuo($event)" style="padding: 0 20rpx;"/>
		</view>
		<view class="" v-if="sousuokuang">
			<view v-for="(item, index) in sousuokuang" :key="index">
			            <view class="article-item" @tap="handleToxiangqing(item.id)">
			                <view class="article-title">
			                    <h3>{{ item.className }}</h3>
			                </view>
			
			                <!-- 图片展示 -->
			                <view class="image-container">
			                    <image v-for="image in [item.urlOne, item.urlTwo, item.urlThree]" :src="image" mode="widthFix" class="article-image"></image>
			                </view>
			
			                <!-- 更新时间 -->
			                <view class="update-time">{{ item.updateTime }}</view>
			            </view>
			        </view>
		</view>
        <view class="tab-bar">
            <!-- 体育按钮 -->
            <view @tap="switchTab('体育')" :class="{ active: activeTab === '体育' }">体育</view>
            <!-- 国际按钮 -->
            <view @tap="switchTab('国际')" :class="{ active: activeTab === '国际' }">国际</view>
            <!-- 娱乐按钮 -->
            <view @tap="switchTab('娱乐')" :class="{ active: activeTab === '娱乐' }">娱乐</view>
        </view>
        
        <!-- 解决请求图片报403 -->
        <meta name="referrer" content="no-referrer" />

        <!-- 文章列表 -->
        <view v-for="(item, index) in shujv" :key="index">
            <view class="article-item" @tap="handleToxiangqing(item.id)">
                <view class="article-title">
                    <h3>{{ item.className }}</h3>
                </view>

                <!-- 图片展示 -->
                <view class="image-container">
                    <image v-for="image in [item.urlOne, item.urlTwo, item.urlThree]" :src="image" mode="widthFix" class="article-image"></image>
                </view>

                <!-- 更新时间 -->
                <view class="update-time">{{ item.updateTime }}</view>
            </view>
        </view>
    </view>
</template>


<script>
    import { get, guoji, tiyv, yvle } from '../../common/api.js'
    
    export default {
        data() {
            return {
                shujv: [],
                zzz: '测试?current=1&size=3&classification=体育', // Default to '体育'
                activeTab: '体育' ,// Track the active tab
				current: 1,
				size: 3,
				sousuokuang:[]
            }
        },
        created() {
            // Fetch articles for the default category on component creation
            this.xinwen(this.zzz);
        },
		onReachBottom() {
			this.zz()
		},
        methods: {
            xinwen(zzz) {
                get(zzz).then((res) => {
                    this.shujv = res[1].data.records;
                    console.log(this.shujv);
                });
            },
            handleToxiangqing(id) {
                uni.navigateTo({
                    url: `/pages/xiangqing/xiangqing?id=${id}`
                });
                console.log(id);
            },
            // Method to switch tabs
            switchTab(tab) {
				let then = this
				if(tab != undefined){
					this.activeTab = tab;
					console.log(tab)
					then.size = 3
					console.log("666"+then.size)
				}else{
					console.log("空")
				}
                this.zzz = `测试?current=1&size=${this.size}&classification=${this.activeTab}`;
                this.xinwen(this.zzz);
            },
			sousuo(event){
				console.log("zz9",event.detail);
				if(event.detail.value != ""){
					let zz = event.detail.value
					let aa = `selectabc?ss=${zz}`
					get(aa).then((res)=>{
						console.log(res[1].data);
						this.sousuokuang = res[1].data
						console.log("99",this.sousuokuang)
					})
				}else{
					this.sousuokuang = null
				}
				
			},
			zz(){
				this.size+=3
				console.log(this.size)
				this.switchTab()
			}
        }
    }
</script>


<style scoped>
    /* 全局样式 */
    .tab-bar {
        display: flex;
        align-items: center;
        justify-content: space-around;
    }
    .tab-bar view {
        cursor: pointer;
    }
    /* 激活选项样式 */
    .active {
        color: blue; /* 更换为你希望的激活颜色 */
        font-weight: bold;
    }
    /* 其他样式保持不变 */
    .article-item {
        margin: 10rpx;
        background-color: #DCDCDC;
        border-radius: 30rpx;
		display: flex;
		flex-direction: column;
		align-items: center;
    }
    .article-title {
        margin: 10rpx;
    }
    .image-container {
        display: flex;
        justify-content: space-around;
        align-items: center;
        margin: 10rpx;
        width: calc(100vw - 40rpx);
        height: 20vh;
    }
    .article-image {
        width: calc(100% - 20rpx);
        max-height: calc(100% - 20rpx);
        padding: 10rpx;
    }
    .update-time {
        margin: 10rpx;
        color: white;
        display: flex;
        flex-direction: row-reverse;
		width: 100%;
    }
</style>
