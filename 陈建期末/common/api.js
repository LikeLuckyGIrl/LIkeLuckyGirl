import {
	baseUrl
} from "./config";

export function yvle() {
	return uni.request({
		url: `${baseUrl}/selectByClassification?classification=娱乐`
	})
}
export function guoji() {
	return uni.request({
		url: `${baseUrl}/selectByClassification?classification=国际`
	})
}
export function tiyv() {
	return uni.request({
		url: `${baseUrl}/selectByClassification?classification=体育`
	})
}
export function zhuang() {
	return uni.request({
		url: `${baseUrl}/selectcad`
	})
}
export function xiangqing(id) {
	return uni.request({
		url: `${baseUrl}/selectId?id=${id}`
	})
}
export function post(classification, particulars, url1, url2, url3, classname) {
	return uni.request({
		url: `${baseUrl}/post`,
		method: "POST",
		header: {
			'content-type': 'application/json' //自定义请求头信息
		},
		data: JSON.stringify({
			classname: classname,
			classification: classification,
			particulars: particulars,
			url1: url1,
			url2: url2,
			url3: url3
		})
	})
}


export function selectByPage(current) {
	return uni.request({
		url: `${baseUrl}/selectByPage?current=${current}&size=10`
	})
}
export function deleteid(id) {
	return uni.request({
		url: `${baseUrl}/delete?id=${id}`,
		method: "DELETE"
	})
}
export function put(id, classification, particulars, url1, url2, url3, classname) {
	return uni.request({
		url: `${baseUrl}/put`,
		method: "POST",
		header: {
			'content-type': 'application/json' //自定义请求头信息
		},
		data: JSON.stringify({
			id: id,
			classname: classname,
			classification: classification,
			particulars: particulars,
			url1: url1,
			url2: url2,
			url3: url3
		})
	})
}