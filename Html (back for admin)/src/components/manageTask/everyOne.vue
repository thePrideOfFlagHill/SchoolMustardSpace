<template>
    <tr class="erry">
        <div class="row">
          <div class="col-md-4">
            <div class="row">
              <div class="col-md-6">
                <img src="" alt="暂无" style="width:100%"/>
              </div>
              <div class="col-md-6">
                <dl class="text-left">
                  <dt>项目名：</dt>
                  <dd>{{name}}</dd>
                  <dt>编号：</dt>
                  <dd>{{id}}</dd>
                </dl>
              </div>
            </div>
          </div>
          <div class="col-md-2">
            {{time}}
          </div>
          <div class="col-md-2">
            {{place}}
          </div>
          <div class="col-md-2">
            {{publisher}}
          </div>
          <div class="col-md-1">
            {{status}}
          </div>
          <div class="col-md-1"></div>
        </div>
    </tr>
</template>

<script>
export default {
  name: 'everyOne',
  data: function () {
    return {
      name: '名字',
      id: '编号',
      time: '1970/12/25',
      place: 'ff',
      publisher: 'zz',
      status: 'kk'
    }
  }
}
</script>

<style>
.erry>div{
    border: 1px solid yellow;

}
.erry>div>div{
  border: 1px solid red;
}
.erry>div>div>div>div{
  border: 1px solid blue;
}
</style>
