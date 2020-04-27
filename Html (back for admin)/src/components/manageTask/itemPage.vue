<template>
    <div>
        <search></search>
        <hr/>
        <showTable></showTable>
    </div>
</template>

<script>
import search from './itemPage/search.vue'
import showTable from './itemPage/table.vue'
export default {
  components: {
    search,
    showTable
  }
}
</script>
