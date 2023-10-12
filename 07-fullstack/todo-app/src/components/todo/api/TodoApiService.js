import axios from 'axios'

const apiClient = axios.create(
    {
        baseURL: 'http://localhost:8080'
    }
);

export const retrieveTodoApi
    = (username, id) => apiClient.get(`/users/${username}/todos/${id}`)

export const retrieveAllTodosForUsernameApi
    = (username) => apiClient.get(`/users/${username}/todos`)
    //http://localhost:8080/users/in28minutes/todos

export const deleteTodoApi
    = (username, id) => apiClient.delete(`/users/${username}/todos/${id}`)
    //http://localhost:8080/users/in28minutes/todos

export const updateTodoApi
    = (username, id, todo) => apiClient.put(`/users/${username}/todos/${id}`, todo)

export const createTodoApi
    = (username,  todo) => apiClient.post(`/users/${username}/todos`, todo)




// example

export const getTodo 
    = () => axios.get('http://localhost:8080/hello-world-bean')

// export const retrieveHelloWorldPathVariable
//     = (username) => apiClient.get(`/hello-world/path-variable/${username}`)