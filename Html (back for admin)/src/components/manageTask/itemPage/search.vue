<template>
  <form class="searchBoxForm " role="form">
    <div class="row">
      <div class="col-xs-2">
        <div class="input-group">
          <input type="text" class="form-control" />
          <div class="input-group-btn">
            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
              状态
              <span class="caret"></span>
            </button>
            <ul class="dropdown-menu pull-right">
              <li>
                <a href="#">功能</a>
              </li>
              <li>
                <a href="#">另一个功能</a>
              </li>
              <li>
                <a href="#">其他</a>
              </li>
            </ul>
          </div>
          <!-- /btn-group -->
        </div>
      </div>

      <div class="col-xs-2">
        <div class="input-group">
          <input type="text" class="form-control" />
          <div class="input-group-btn">
            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
              筛选条件
              <span class="caret"></span>
            </button>
          </div>
        </div>
      </div>

      <div class="col-xs-2">
        <div class="input-group">
          <input type="text" class="form-control" />
        </div>
      </div>

      <div class="col-xs-2">
        <div class="input-group">
          <button type="button" class="btn btn-default">搜索</button>
        </div>
      </div>
    </div>
  </form>
</template>

<script>
export default {
  name: 'serachBox'
}
</script>

<style scoped>
.searchBoxForm{
  margin: 10px 0;
}
</style>
