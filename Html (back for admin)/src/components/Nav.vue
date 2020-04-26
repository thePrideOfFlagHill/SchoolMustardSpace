<template>
  <nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
    <div class="navbar-header pull-left">
        <a class="navbar-brand" href="#">后台</a>
    </div>
    <div class="pull-right">
        <ul class="nav navbar-nav">
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    <label id='user'>用户</label>
                    <b class="caret"></b>
                </a>
                <ul class="dropdown-menu">
                    <li><a href="#">jmeter</a></li>
                    <li><a href="#">EJB</a></li>
                    <li><a href="#">Jasper Report</a></li>
                    <li class="divider"></li>
                    <li><a href="#">分离的链接</a></li>
                    <li class="divider"></li>
                    <li><a href="#">另一个分离的链接</a></li>
                </ul>
            </li>
        </ul>
    </div>
    </div>
  </nav>
</template>

<script>

export default {
  name: 'Nav'
}
</script>
