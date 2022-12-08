<template>
  <div>
    <HeaderComp></HeaderComp>
    <AddComp></AddComp>
    <ContentComp></ContentComp>
    <FooterComp></FooterComp>
  </div>
</template>

<script>
import HeaderComp from "../components/HeaderComp.vue";
import AddComp from "../components/AddComp.vue";
import ContentComp from "../components/ContentComp.vue";
import FooterComp from "../components/FooterComp.vue";

export default {
  name: "AddStudent",
  components: {
    HeaderComp,
    AddComp,
    ContentComp,
    FooterComp,
  },
};
</script>

<style>
</style>
