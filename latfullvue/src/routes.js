import AddStudent from "./pages/AddStudent.vue";
import AddForm from "./pages/AddForm.vue";
import Update from "./pages/Update.vue";



export default [
    {
        path: "/",
        component: AddStudent,
    },
    {
        path: "/AddForm",
        component: AddForm,
    },
    {
        path: "/update/:id",
        component: Update,
    }
]