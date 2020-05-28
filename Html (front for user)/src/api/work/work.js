import request from '@/plugin/axios';
export function GetWorkList(data) {
    return request({
        url:'/api/task/query/all',
        method:'get',
        data
    })
}