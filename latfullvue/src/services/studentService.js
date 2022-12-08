import http from "../http-common.js";

class studentService{
    create(data){
        return http.post("/student/insert", data);
    }

    getAll(){
        return http.get("/student/getAll");
    }

    delete(id){
        return http.delete(`/student/delete/${id}`);
    }

    updateStudent(id, data){
        return http.put(`/student/update/${id}`, data);
    }

    getStudent(id, data){
        return http.get(`/student/getStudent/${id}`, data);
    }
}

export default new studentService();