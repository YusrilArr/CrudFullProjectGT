.<template>
  <div>
    <div class="d-flex flex-wrap">
      <div class="row my-5 col-12">
        <div
          class="col-4 mt-4"
          v-for="(item, index) in studentData"
          :key="item.id"
        >
          <div class="card-body border border-warning">
            <h5 class="card-title">
              {{ item.nama + ", " + item.umur + " Years Old" }}
            </h5>
            <p class="card-text">{{ item.deskripsi_diri }}</p>
            <table>
              <tr>
                <td>Email</td>
                <td>: {{ item.email }}</td>
              </tr>
              <tr>
                <td>Soft Skill</td>
                <td>: {{ item.soft_skill }}</td>
              </tr>
              <tr>
                <td>Hard Skill</td>
                <td>: {{ item.hard_skill }}</td>
              </tr>
              <tr>
                <td>Interest</td>
                <td>: {{ item.interest }}</td>
              </tr>
            </table>

            <div class="d-flex flex-row justify-content-between">
              <div>
                <router-link :to="{ path: '/update/' + item.id }">
                  <button class="btn btn-primary mt-3">Update</button>
                </router-link>

                <button
                  class="btn btn-danger ml-3 mt-3"
                  @click="deleteStudentFunc(item.id, index)"
                >
                  Delete
                </button>
              </div>
              <div>
                <img
                  class="male"
                  v-if="item.jenis_kelamin == 'Male'"
                  src="../assets/male.png"
                  alt="male"
                />
                <img
                  class="female"
                  v-if="item.jenis_kelamin == 'Female'"
                  src="../assets/female.png"
                  alt="female"
                />
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import studentService from "../services/studentService";

export default {
  name: "ContentComp",
  data() {
    return {
      studentData: null,
    };
  },

  components: {},

  methods: {
    getStudent() {
      studentService
        .getAll()
        .then((response) => {
          this.studentData = response.data;
          console.log(this.studentData);
        })
        .catch((e) => {
          console.log(e);
        });
    },

    deleteStudentFunc(id, index) {
      if (confirm("Are you sure want to delete?")) {
        studentService
          .delete(id)
          .then(
            this.studentData.splice(index, 1),
            (this.isDeleted = true),
            this.$emit("hasDeleted", this.isDeleted)
          )
          .catch((e) => {
            console.log(e);
          });
      } else {
        alert("Delete canceled");
      }
    },
  },
  mounted() {
    this.getStudent();
  },
};
</script>

<style scoped>
.male {
  width: 50px;
  height: auto;
}
.female {
  height: 50px;
  width: auto;
}
</style>