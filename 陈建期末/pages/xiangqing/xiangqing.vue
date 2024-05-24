<template>
	<view>
		<view class="" style="margin: 20rpx;">
			<h3>{{shujv[0].classname}}</h3>
		</view>
		
		<view class="" style="margin: 20rpx;">
			<text>{{shujv[0].particulars}}</text>
		</view>
		<view class="" style="margin: 20rpx;">
			<image :src="shujv[0].url1" mode="widthFix" style="width: 100%;"></image>
		</view>
		<view class="" style="margin: 20rpx;">
			<image :src="shujv[0].url2" mode="widthFix" style="width: 100%;"></image>
		</view>
		<view class="" style="margin: 20rpx;">
			<image :src="shujv[0].url3" mode="widthFix" style="width: 100%;"></image>
		</view>		
	</view>
</template>

<script>
import { xiangqing } from '../../common/api'
	export default {
		data() {
			return {
				shujv:[]
			}
		},
		onLoad(oc) {
			console.log(oc)
			xiangqing(oc.id).then((res)=>{
				console.log(res[1].data)				
				this.shujv = res[1].data
				console.log(this.shujv[0])
			})
		},
		methods: {
			
		}
	}
</script>

<style>

</style>
