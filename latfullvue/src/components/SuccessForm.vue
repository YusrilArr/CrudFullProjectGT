.<template>
  <div>
    <div class="card-body border-color-pink">
      <h5 class="card-title">Success!</h5>
      <p class="card-text">Your Data Has Been Submitted!</p>
      <router-link to="/" class="btn bg-color-pink text-dark">OK</router-link>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style>
.border-color-pink {
  border: solid 2px #f9cada;
}
.bg-color-pink {
  background-color: #f9cada;
}
</style>