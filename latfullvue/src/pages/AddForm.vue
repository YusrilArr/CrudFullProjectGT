<template>
  <div>
    <HeaderComp></HeaderComp>
    <FormComp></FormComp>
    <FooterComp></FooterComp>
  </div>
</template>

<script>
import HeaderComp from "../components/HeaderComp.vue";
import FormComp from "../components/FormComp.vue";
import FooterComp from "../components/FooterComp.vue";

export default {
  name: "AddForm",
  components: {
    HeaderComp,
    FormComp,
    FooterComp,
  },
};
</script>

<style>
</style>