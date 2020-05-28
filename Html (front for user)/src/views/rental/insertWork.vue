<template>
  <d2-container>
    <template slot="header">发布租凭</template>
    <el-row class="d2-text-center">
      <el-col :span="7"></el-col>
      <el-col :span="2" style="margin-top:25px">物品名称：</el-col>
      <el-col :span="6">
        <el-input v-model="title" placeholder="物品名称" size="small"></el-input>
      </el-col>
      <el-col :span="9"></el-col>
    </el-row>
    <el-row class="d2-text-center" style="margin-top:20px;">
      <el-col :span="7"></el-col>
      <el-col :span="2" style="margin-top:25px">截止时间：</el-col>
      <el-col :span="6">
        <el-date-picker
          v-model="time"
          type="daterange"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
          :default-time="['00:00:00', '23:59:59']"
          size="small"
          class="d2-fl"
        ></el-date-picker>
      </el-col>
      <el-col :span="9"></el-col>
    </el-row>
    <el-row class="d2-text-center">
      <el-col :span="7"></el-col>
      <el-col :span="2" style="margin-top:25px">物品描述：</el-col>
      <el-col :span="6">
        <el-input v-model="contents" type="textarea" :rows="3" placeholder="请描述你的物品"></el-input>
      </el-col>
      <el-col :span="9"></el-col>
    </el-row>
    <el-row class="d2-text-center">
      <el-col :span="7"></el-col>
      <el-col :span="2" style="margin-top:25px">新旧程度：</el-col>
      <el-col :span="6">
        <el-input v-model="newDgree" placeholder="新旧程度1-100" size="small"></el-input>
      </el-col>
      <el-col :span="9"></el-col>
    </el-row>
    <el-row class="d2-text-center" style="margin-top:20px;">
      <el-col :span="7"></el-col>
      <el-col :span="2" style="margin-top:25px">添加图片：</el-col>
      <el-col :span="15">
        <el-upload
          class="d2-fl"
          action
          list-type="picture-card"
          :on-preview="handlePictureCardPreview"
          :on-remove="handleRemove"
          :http-request="upload1"
          :before-upload="getImg"
          :limit="1"
        >
          <i class="el-icon-plus"></i>
        </el-upload>
        <el-dialog :visible.sync="dialogVisible">
          <img width="100%" :src="dialogImageUrl" alt />
        </el-dialog>
      </el-col>
    </el-row>
    <el-row class="d2-text-center" style="margin-top:20px;">
      <el-col :span="7"></el-col>
      <el-col :span="2" style="margin-top:25px">租凭价格：</el-col>
      <el-col :span="6">
        <el-input v-model="money" placeholder="￥" size="small"></el-input>
      </el-col>
      <el-col :span="9"></el-col>
    </el-row>
    <el-row class="d2-text-center" style="margin-top:50px">
      <el-button type="primary" @click="upload()">发布</el-button>
    </el-row>
  </d2-container>
</template>

<script>
import axios from 'axios';
import {formatDate} from '../../assets/js/index';
export default {
  name: "page2",
  data() {
    return {
      title: "",
      contents: "",
      money: "",
      time: "",
      pickerOptions: {
        shortcuts: [
          {
            text: "最近一周",
            onClick(picker) {
              const end = new Date();
              const start = new Date();
              start.setTime(start.getTime() - 3600 * 1000 * 24 * 7);
              picker.$emit("pick", [start, end]);
            }
          },
          {
            text: "最近一个月",
            onClick(picker) {
              const end = new Date();
              const start = new Date();
              start.setTime(start.getTime() - 3600 * 1000 * 24 * 30);
              picker.$emit("pick", [start, end]);
            }
          },
          {
            text: "最近三个月",
            onClick(picker) {
              const end = new Date();
              const start = new Date();
              start.setTime(start.getTime() - 3600 * 1000 * 24 * 90);
              picker.$emit("pick", [start, end]);
            }
          }
        ]
      },
      dialogImageUrl: "",
      dialogVisible: false,
      img:new FormData(),
      newDgree : ""
    };
  },
  computed:{
    userid:function(){
      return this.$store.state.userid
    }
  },
  methods: {
    async consoleLog() {
      console.log(this.time);
    },
    handleRemove(file, fileList) {
      console.log(file, fileList);
    },
    handlePictureCardPreview(file) {
      this.dialogImageUrl = file.url;
      this.dialogVisible = true;
    },
    getImg(file) {
      this.img.append('file',file);
    },
    upload1(){
    },
    async uploadImg(img) {
        // this.img.append('id',id);
     
      const {data} =  await axios.post('upload/good/setFileUpload',img);
        console.log(data);
        
    },
    async upload(){
       
        console.log(this.img.get('img'));
        const {data} = await axios.post('/api/rental/insert ',{
        //  "user_id":13,
        //  "title":this.title,
        //  "content":this.contents,
        //  "img":this.img,
        //  "label":"其他",
        //  "location":"",
        //  "is_done":0,
        //  "reword":this.money,
        //  "start_time":formatDate(this.time[0]),
        //  "end_time":formatDate(this.time[1]),
        //  "thumb_up":0,
	      //  "collect":0,
        //  "comment":0
          "userId":this.userid,
          "title":this.title,
          "content":this.contents,
          "image":"",
          "label":"其他",
          "location":"",
          "startTime":formatDate(this.time[0]),
          "endTime":formatDate(this.time[1]),
          "unitPrice":12.3,
          "newDegree":90   //新旧程度

        })
        console.log(data);
        this.img.append('id',data.data);
        // console.log()
        this.$options.methods.uploadImg(this.img);
        
        
        
    }
  }
};
</script>
<style  scoped>
.el-col {
  margin-top: 20px;
}
</style>