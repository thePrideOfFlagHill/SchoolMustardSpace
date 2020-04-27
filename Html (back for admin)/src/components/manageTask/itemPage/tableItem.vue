<template>
    <tr class="every ">
      <td>
        <div class="row">
            <div class="col-md-4">
              <div class="row">
                <div class="col-md-6 photo">
                  <img :src="imgSrc" alt="暂无" />
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
            <div class="col-md-1">
              {{publisher}}
            </div>
            <div class="col-md-1">
              {{status}}
            </div>
            <div class="col-md-1">
              <button type="button" class="btn btn-link" @click="toDetail">查看</button>
            </div>
            <div class="col-md-1"></div>
        </div>
      </td>
    </tr>
</template>

<script>
// 本地必须用requie方法进行导入图片，否在无法加载图片

export default {
  name: 'everyOne',
  data: function () {
    return {
      imgSrc: 'https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1585791891&di=0b1b32fbff9636c9534f0b85909b5791&src=http://a0.att.hudong.com/78/52/01200000123847134434529793168.jpg',
      name: '名字',
      id: '编号',
      time: '1970/12/25',
      place: 'ff',
      publisher: 'zz',
      status: 'kk'
    }
  },
  props: {
    code: String
  },
  methods: {
    toDetail: function () {
      this.$router.push({ path: '/manageTask/detail' })
    }
  }
}

</script>

<style scoped>
.row{
    display: flex;
    justify-content:center;
    align-items:Center;
}
.photo>img{
  width: 90%;
  padding: 10%;
}
.every{
    border: 1px solid gainsboro;
}
.every>td{
    background: white;

}

</style>
