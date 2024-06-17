<template>
    <view>
		<view class="" style="background-color: #dfdfdf; border: solid black 4rpx;">
			<input type="text" @input="zz"/>
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
                zzz: 'selectByClassification?classification=体育', // Default to '体育'
                activeTab: '体育' // Track the active tab
            }
        },
        created() {
            // Fetch articles for the default category on component creation
            this.xinwen(this.zzz);
        },
        methods: {
            xinwen(zzz) {
                get(zzz).then((res) => {
                    this.shujv = res[1].data;
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
                this.zzz = `selectByClassification?classification=${tab}`;
                this.activeTab = tab;
                this.xinwen(this.zzz);
            },
			zz(event){
				console.log("zz",event.target.value);
				let zz = event.target.value
				let aa = `selectabc?ss=${zz}`
				this.xinwen(aa)
				
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
