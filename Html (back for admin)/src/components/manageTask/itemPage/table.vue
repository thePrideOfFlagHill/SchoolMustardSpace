<template>
    <div class="roughShow container-fluid">
        <table class="table table-striped">
            <thead>
                <tr>
                    <td>
                        <div class="row" >
                            <div class="col-md-4">简述</div>
                            <div class="col-md-2">起始时间</div>
                            <div class="col-md-2">地点</div>
                            <div class="col-md-1">发布人</div>
                            <div class="col-md-1">状态</div>
                            <div class="col-md-1">操作</div>
                            <div class="col-md-1"></div>
                        </div>
                    </td>
                </tr>
            </thead>
            <tbody>
                <tableItem></tableItem>
                <tableItem></tableItem>
                <tableItem></tableItem>
            </tbody>
        </table>

        <ul class="pagination">
            <li><a href="#">&laquo;</a></li>
            <li><a href="#">1</a></li>
            <li><a href="#">2</a></li>
            <li><a href="#">3</a></li>
            <li><a href="#">4</a></li>
            <li><a href="#">5</a></li>
            <li><a href="#">&raquo;</a></li>
        </ul>

    </div>
</template>

<script>
import tableItem from './tableItem.vue'

export default {
  name: 'roughShow',
  components: {
    tableItem
  }
}
</script>

<style scoped>
.roughShow{
  background: whitesmoke;
}
</style>
