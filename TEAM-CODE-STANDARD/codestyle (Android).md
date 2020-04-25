# 命名规范

## 类名

- ①Activity 类，Activity 为后缀标识。
- ②Adapter 类，Adapter 为后缀标识。
- ③BroadcastReceiver 类，以 Receiver 为后缀标识。
- ④ 自定义的共享基础类， 以 Base 开头。

## 方法名

- ①initXX()，初始化相关方法。
- ②isXX(), checkXX()，方法返回值为 boolean 型。
- ③getXX()，返回某个值的方法。
- ④setXX()，设置某个属性值。
- ⑤displayXX(), showXX()，弹出提示框和提示信息。
- ⑥updateXX()，更新数据。
- ⑦resetXX()，重置数据。

## 常量名

- ① 常量名命名模式为 CONSTANT_CASE，全部字母大写，用下划线分隔单词。

## 非常量字段名

- ① 非常量字段名以 lowerCamelCase 风格。

## 布局资源文件

- ① 命名规则：类型*模块名、类型{*模块名}\_逻辑名称。

## id 命名

- ① 命名规则：view 缩写{*模块名}*逻辑名，例如： btn_main_search、btn_back。

# 代码样式规范

## 大括号

- ① 左大括号不单独占一行，与其前面的代码位于同一行。

## 行长限制

- ① 代码中每一行文本的长度都应该不超过 100 个字符。

# 第三方库规范

- ① 一般都需要选择比较稳定的版本。具体参考：<https://www.ctolib.com/cheatsheets-Android-ch.html>

# 注释规范

## 类注释

```Java
/**
* 描述信息
*
* @author xxx
* @since 2020年4月25日13:55:06
* @其他
*/
```

## 方法注释

```Java
/**
 * bitmap 转 byteArr
 *
 * @param bitmap bitmap 对象
 * @param format 格式
 * @return 字节数组
 */
```

# UI 控件缩写表

- ① 参考：<https://www.jianshu.com/p/45c1675bec69>
