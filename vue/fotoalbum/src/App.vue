<script setup>
import { RouterLink, RouterView } from 'vue-router'
import HeaderApp from './components/HeaderApp.vue'
</script>

<template>
  <HeaderApp/>

  <RouterView />
</template>

<style>
@import url(../node_modules/bootstrap);
</style>
