<template>
  <div>
    <el-menu
      class="Nav"
      mode="horizontal"
      background-color="#545c64"
      text-color="#fff"
      active-text-color="#ffd04b"
    >
      <el-menu-item index="1">处理中心</el-menu-item>
      <el-menu-item index="3" style="float:right;" @click="uploadApk">上传apk</el-menu-item>
      <el-submenu index="2" style="float:right;">
        <template slot="title">{{this.$store.state.accountNumber}}</template>
        <el-menu-item index="2-1" @click="loginOut()">退出</el-menu-item>
        <el-menu-item index="2-2">选项2</el-menu-item>
        <el-menu-item index="2-3">选项3</el-menu-item>
      </el-submenu>
    </el-menu>
    <el-dialog title="提示" :visible.sync="centerDialogVisible" width="30%" center>
      <el-upload
        class="upload-demo"
        ref="upload"
        :action="url"
        :on-success="sunccess"
        :on-error="wrong"
        :file-list="fileList"
        :auto-upload="false"
        :multiple="false"
        :data="edition"
      >
        <el-button slot="trigger" size="small" type="primary">选取文件</el-button>
        <el-button
          style="margin-left: 10px;"
          size="small"
          type="success"
          :limit="1"
          @click="submitUpload"
        >上传到服务器</el-button>
      </el-upload>
      <el-form ref="form" :model="form" label-width="80px">
        <el-form-item label="版本">
          <el-input v-model="edition.edition"></el-input>
        </el-form-item>
      </el-form>

      <span slot="footer" class="dialog-footer">
        <el-button @click="centerDialogVisible = false">取 消</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: 'Nav',
  data () {
    return {
      centerDialogVisible: false,
      edition: {
        edition: ''
      }
    }
  },
  computed: {
    url: function () {
      return this.$store.state.headPort + '/api/edition/upload'
    }
  },
  methods: {
    loginOut () {
      this.$store.commit('setAccountnumber', null)
      if (this.$store.state.accountNumber == null) {
        this.$router.push({
          name: 'login'
        })
      }
    },
    uploadApk () {
      this.centerDialogVisible = true
    },
    submitUpload () {
      this.$refs.upload.submit()
    },
    sunccess (response, file, fileList) {
      this.$message({
        message: '文件上传成功',
        type: 'success'
      })
    },
    wrong (e, file, fileList) {
      this.$message.error('错了哦，这是一条错误消息')
    }
  }
}
</script>

<style scoped>
</style>
