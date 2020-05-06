<template>
  <div class="shadow box">
    <el-form ref="form" :model="form" label-width="80px">
      <el-form-item label="账号：">
        <el-input v-model="form.id" disabled></el-input>
      </el-form-item>
      <el-form-item label="密码：">
        <el-input v-model="form.password"></el-input>
      </el-form-item>
      <el-form-item label="用户名：">
        <el-input v-model="form.name"></el-input>
      </el-form-item>
      <el-form-item label="性别">
        <el-select v-model="form.sex" placeholder="性别">
          <el-option label="男" value="0"></el-option>
          <el-option label="女" value="1"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="电话：">
        <el-input v-model="form.phoneNumber"></el-input>
      </el-form-item>
      <el-form-item label="地址：">
        <el-input v-model="form.address"></el-input>
      </el-form-item>
      <el-form-item label="签名">
        <el-input v-model="form.info"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">修改</el-button>
        <el-button @click="cancel">取消</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  name: 'changeAdmin',
  data: function () {
    return {
      form: {
        id: '',
        password: '',
        sex: '',
        name: '',
        phoneNumber: '',
        address: '',
        head: '',
        info: ''
      }
    }
  },
  methods: {
    onSubmit () {
      var that = this
      var page = this.form

      this.$axios
        .post(this.$store.state.headPort + '/api/user/update', {
          accountNumber: page.accountNumber,
          password: page.password,
          sex: page.sex,
          name: page.name,
          phoneNumber: page.phoneNumber,
          head: page.head,
          address: page.address,
          info: page.info
        })
        .then(function (response) {
          that.$alert('修改成功', '', {
            confirmButtonText: '确定',
            callback: action => {
              that.$router.go(-1)
            }
          })
        })
        .catch(function (error) {
          console.log(error)
        })
    },
    cancel: function () {
      this.$router.go(-1)
    }
  },
  // 初始化函数
  mounted: function () {
    this.form.id = this.$route.query.id
    console.log(this.$route.query.id)
    // 根据id访问接口获取数据
    var page = this.form
    this.$axios
      .get(this.$store.state.headPort + '/api/user/query/id/' + this.$route.query.id)
      .then(function (response) {
        var data = response.data.data
        console.log(data)
        page.head = data.head
        page.name = data.name
        page.phoneNumber = data.phoneNumber
        page.accountNumber = data.accountNumber
        page.sex = data.sex
        page.address = data.address
        page.info = data.info
      })
      .catch(function (error) {
        console.log(error)
      })
  }
}
</script>

<style scoped>
.shadow {
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
  background: white;
}
.box {
  padding: 10px;
  width: 50%;
  display: flex;
  justify-content: center;
}
</style>
