.<template>
  <div>
    <div class="">
      <router-link to="/" tag="button" class="btn btn-primary mt-lg-4 ml-lg-4"
        >Back</router-link
      >
    </div>

    <div class="row justify-content-center my-5" id="form-main">
      <form
        class="col-8 border border-primary p-5"
        id="input-form"
        @submit.prevent="inputStudent"
        v-show="!success"
      >
        <h1 class="d-flex justify-content-center mb-5">Add Student</h1>
        <div class="form-row">
          <div class="form-group col-md-6">
            <label for="inputEmail4">Student Name</label>
            <input
              v-model="studentData.nama"
              type="text"
              class="form-control"
              id="inputName"
              placeholder="Input Your Name"
              required
            />
          </div>
          <div class="form-group col-md-6">
            <label for="inputPassword4">SoftSkill</label>
            <input
              v-model="studentData.soft_skill"
              type="text"
              class="form-control"
              id="inputSoftskill"
              placeholder="SoftSkill"
            />
          </div>
        </div>
        <div class="form-row">
          <div class="form-group col-md-3">
            <label for="inputAge">Student Age</label>
            <input
              v-model="studentData.umur"
              type="number"
              class="form-control"
              id="inputAge"
              placeholder="Input Your Age"
            />
          </div>
          <div class="form-group col-md-3">
            <label for="inputAge">Gender</label>
            <select class="custom-select" v-model="studentData.jenis_kelamin">
              <option selected>Select Your Gender</option>
              <option value="Male">Male</option>
              <option value="Female">Female</option>
              <option value="X">Undetected</option>
            </select>
          </div>
          <div class="form-group col-md-6">
            <label for="inputAge">HardSkill</label>
            <input
              v-model="studentData.hard_skill"
              type="text"
              class="form-control"
              id="inputHardskill"
              placeholder="Enter Hard Skill"
            />
          </div>
        </div>
        <div class="form-row">
          <div class="form-group col-md-6">
            <label for="inputEmail">Student Email</label>
            <input
              v-model="studentData.email"
              type="text"
              class="form-control"
              id="inputEmail"
              placeholder="Input Your Email"
            />
          </div>
          <div class="form-group col-md-6">
            <label for="inputEmail">Interest</label>
            <select class="custom-select" v-model="studentData.interest">
              <option selected></option>
              <option value="Data Science">Data Science</option>
              <option value="Networking">Network</option>
              <option value="Web Frontend">Web Frontend</option>
              <option value="Web Backend">Web Backend</option>
              <option value="Mobile Apps">Mobile Apps</option>
            </select>
          </div>
        </div>
        <div class="form-row">
          <div class="form-group col-md-12">
            <label for="inputDescription">Self Description</label>
            <textarea
              class="form-control"
              id="inputDescription"
              v-model="studentData.deskripsi_diri"
            />
          </div>
        </div>
        <div class="form-group">
          <div class="form-check">
            <input class="form-check-input" type="checkbox" id="gridCheck" />
            <label class="form-check-label" for="gridCheck">
              Check me out
            </label>
          </div>
        </div>
        <button type="submit" class="btn btn-primary">{{ buttonValue }}</button>
      </form>
      <!-- Success Section -->
      <SuccessForm v-show="success"></SuccessForm>
    </div>
  </div>
</template>

<script>
import studentService from "../services/studentService";
import SuccessForm from "../components/SuccessForm.vue";

export default {
  data() {
    return {
      studentData: {
        name: null,
        soft_skill: null,
        umur: null,
        jenis_kelamin: null,
        hard_skill: null,
        email: null,
        interest: null,
        deskripsi_diri: null,
      },
      success: false,
      buttonValue: "Submit",
    };
  },

  methods: {
    inputStudent() {
      let data = this.studentData;

      if (this.buttonValue == "Submit") {
        studentService
          .create(data)
          .then((response) => {
            console.log(response.data);
            this.success = true;
          })
          .catch((e) => {
            console.log(e);
          });
      } else {
        studentService
          .updateStudent(data.id, data)
          .then((response) => {
            console.log(response.data);
            this.success = true;
          })
          .catch((e) => {
            console.log(e);
          });
      }
    },
  },

  name: "FormComp",
  components: {
    SuccessForm,
  },

  props: ["studentDataProps"],
  watch: {
    studentDataProps(newValue) {
      this.studentData = newValue;
      console.log(this.studentData);
      this.buttonValue = "Update";
    },
  },
};
</script>

<style>
</style>