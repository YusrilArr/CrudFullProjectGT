<template>
  <div>
    <HeaderComp></HeaderComp>
    <UpdateForm></UpdateForm>
    <FooterComp></FooterComp>
  </div>
</template>

<script>
import HeaderComp from "../components/HeaderComp.vue";
import UpdateForm from "../components/UpdateForm.vue";
import FooterComp from "../components/FooterComp.vue";

export default {
  name: "AddStudent",
  components: {
    HeaderComp,
    UpdateForm,
    FooterComp,
  },
};
</script>

<style>
</style>
