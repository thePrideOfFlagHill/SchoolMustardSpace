export const formatDate = (dateA) => {
    var dateee = new Date(dateA).toJSON();
    var date = new Date(+new Date(dateee)+8*3600*1000).toISOString().replace(/T/g,' ').replace(/\.[\d]{3}Z/,'');
    return date;
}
export function formatDataWork(val){
    const newVal = [];
    val.forEach((item)=>{
        const detail = {};
        detail.collect = item.collect;
        detail.comment = item.comment;
        detail.content = item.content;
        detail.end_time = item.end_time || item.endTime;
        detail.id = item.id;
        detail.image = item.image;
        detail.is_done = item.is_done || item.isDone;
        detail.label = item.label;
        detail.location = item.location;
        detail.reword = item.reword || item.unitPrice;
        detail.start_time = item.start_time || item.startTime || item.time;
        detail.thumb_up = item.thumb_up || item.thumbUp;
        detail.title = item.title;
        detail.user_id = item.user_id || item.userId;
        newVal.push(detail);
    });
    return newVal;
}