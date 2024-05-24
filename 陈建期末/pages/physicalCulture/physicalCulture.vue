<template>

	<view>
		<meta name="referrer" content="no-referrer" /><!--解决请求图片报403-->

		<view v-for="(item,index) in shujv" :key="index">
			<view class="" style="margin: 10rpx; background-color: #DCDCDC; border-radius: 30rpx;"
				@tap="handleToxiangqing(item.id)">
				<view class="" style="margin: 10rpx;">
					<h3>{{item.classname}}</h3>
				</view>

				<view class=""
					style="display: flex; justify-content: space-around; align-items: center; margin: 10rpx; width: calc(100vw - 40rpx); height: 20vh;">
					<view class=""
						style="flex: 1; height: 100%; display: flex; justify-content: center; align-items: center;;">
						<image :src="item.url1" mode="widthFix"
							style="width: calc(100% - 20rpx); max-height: calc(100% - 20rpx);padding: 10rpx;">
						</image>
					</view>
					<view class=""
						style="flex: 1; height: 100%; display: flex; justify-content: center; align-items: center;;">
						<image :src="item.url2" mode="widthFix"
							style="width: calc(100% - 20rpx); max-height: calc(100% - 20rpx);padding: 10rpx;">
						</image>
					</view>
					<view class=""
						style="flex: 1; height: 100%; display: flex; justify-content: center; align-items: center;;">
						<image :src="item.url3" mode="widthFix"
							style="width: calc(100% - 20rpx); max-height: calc(100% - 20rpx);padding: 10rpx;">
						</image>
					</view>

				</view>
				<view class="" style="margin: 10rpx; color: white; display: flex; flex-direction: row-reverse;">
					{{item.updatetime}}
				</view>
			</view>
		</view>
	</view>
</template>

<script>
	import {
		tiyv
	} from '../../common/api'
	export default {
		data() {
			return {
				shujv: [{
					biaoti: "标题",
					id: 1,
					tupian: "https://p3-sign.toutiaoimg.com/tos-cn-i-axegupay5k/10ee889a1d05413291698e68f6fe908d~noop.image?_iz=58558&from=article.pc_detail&lk3s=953192f4&x-expires=1716548593&x-signature=WTKKsZOQ5NeItm82ae%2BEZd2ucPs%3D"
				}]
			}
		},
		onLoad() {
			tiyv().then((res) => {
				console.log(res[1].data)
				//this.shujv[0].tupian = res[1].data[0].url1
				this.shujv = res[1].data
				console.log(this.shujv)

			})
		},
		methods: {
			handleToxiangqing(id) {
				uni.navigateTo({
					url: `/pages/xiangqing/xiangqing?id=${id}`
				})
				console.log(id)
			}
		}
	}
</script>

<style>

</style>