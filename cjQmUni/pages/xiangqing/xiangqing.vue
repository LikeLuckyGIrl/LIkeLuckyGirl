<template>
	<view>
		<view class="" style="margin: 20rpx;">
			<h3>{{shujv[0].className}}</h3>
		</view>
		
		<view class="" style="margin: 20rpx;">
			<text>{{shujv[0].particulars}}</text>
		</view>
		<view class="" style="margin: 20rpx;">
			<image :src="shujv[0].urlOne" mode="widthFix" style="width: 100%;"></image>
		</view>
		<view class="" style="margin: 20rpx;">
			<image :src="shujv[0].urlTwo" mode="widthFix" style="width: 100%;"></image>
		</view>
		<view class="" style="margin: 20rpx;">
			<image :src="shujv[0].urlThree" mode="widthFix" style="width: 100%;"></image>
		</view>		
	</view>
</template>

<script>
import { get, xiangqing } from '../../common/api'
	export default {
		data() {
			return {
				shujv:[]
			}
		},
		onLoad(oc) {
			console.log(oc.id)
			let aa ='selectId/?id='+oc.id
			get(aa).then((res)=>{
				console.log(aa)
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
