<template>
	<view class="charts-box">
		<qiun-data-charts type="column" :opts="opts" :chartData="chartData" />
	</view>
</template>

<script>
	import {
		zhuang
	} from '../../common/api';
	export default {
		data() {
			return {
				chartData: {},
				//您可以通过修改 config-ucharts.js 文件中下标为 ['column'] 的节点来配置全局默认参数，如都是默认参数，此处可以不传 opts 。实际应用过程中 opts 只需传入与全局默认参数中不一致的【某一个属性】即可实现同类型的图表显示不同的样式，达到页面简洁的需求。
				opts: {
					color: ["#1890FF", "#91CB74", "#FAC858", "#EE6666", "#73C0DE", "#3CA272", "#FC8452", "#9A60B4",
						"#ea7ccc"
					],
					padding: [15, 15, 0, 5],
					enableScroll: false,
					legend: {},
					xAxis: {
						disableGrid: true
					},
					yAxis: {
						data: [{
							min: 0
						}]
					},
					extra: {
						column: {
							type: "group",
							width: 30,
							activeBgColor: "#000000",
							activeBgOpacity: 0.08
						}
					}
				}
			};
		},
		onLoad() {
			//this.getServerData();
			/*zhuang().then((res) => {
				console.log(res[1].data);
				const categories = res[1].data.map(item => item.classification)
				const values = res[1].data.map(item => item.shu)
				let zzz = {
					categories: categories,
					series: [{
						data: values,
						name: '值'
					}]
				}
				this.chartData = JSON.parse(JSON.stringify(zzz));
			})
			*/
		   
		},
		onReady() {
			this.getServerData();
		},
		methods: {
			getServerData(){
				var then =this
				setTimeout(() => {
					uni.request({
						url: 'http://127.0.0.1:7001/selectcad',
						success(abc) {
							const categories = abc.data.map(item => item.classification)
							const values = abc.data.map(item => item.shu)
							let res = {
								categories: categories,
								series: [{
										name: "看着写",
										data:values
									}
								]
							}
							then.chartData = JSON.parse(JSON.stringify(res));
						}
					})
				}, 500);
			}
			
		}
	};
</script>

<style scoped>
	/* 请根据实际需求修改父元素尺寸，组件自动识别宽高 */
	.charts-box {
		width: 100%;
		height: 300px;
	}
</style>