import { useState, useEffect } from 'react'
import {useNavigate} from 'react-router-dom'
import { retrieveAllTodosForUsernameApi, deleteTodoApi } from './api/TodoApiService'
import { useAuth } from './security/AuthContext'

export default function ListTodosComponent() {

    const authContext = useAuth()

    const navigate = useNavigate()

    const username = authContext.username

    const [todos,setTodos] = useState([])

    const [message,setMessage] = useState(null)
    
    useEffect ( () => {
        refreshTodos()
    }, [])


    function updateTodo(id) {
        navigate(`/todo/${id}`)
    }

    function refreshTodos() {
        retrieveAllTodosForUsernameApi(username)
        .then(response => {
            setTodos(response.data)
        }
            
        )
        .catch(error => console.log(error))
    }

    function deleteTodo(id) {
        console.log('clicked ' + id)
        deleteTodoApi(username, id)
        .then(
            
            // 삭제 응답을 받았으면 무엇을 해야할 까?
            //1: 삭제 성공 메세지를 출력한다.
            //2: 삭제 후 새로운 todo리스트를 출력해줘야한다. -> todo리스트를 api로 호출한다.(바뀐 내용이 state에 적용, 화면에 출력)
            () => {
                setMessage(`Delete of todo with id = ${id} successful`)
                refreshTodos()
            }
        )
        .catch(error => console.log(error))
    }

    function addNewTodo() {
        navigate(`/todo/-1`)
    }

    return (
        <div className="container">
            <h1>Things You Want To Do!</h1>
            {message && <div className="alert alert-warning">{message}</div>}
            <div>
                <table className="table">
                    <thead>
                            <tr>
                                <th>ID</th>
                                <th>Description</th>
                                <th>Is Done?</th>
                                <th>Target Date</th>
                                <th>Delete</th>
                                <th>Update</th>
                            </tr>
                    </thead>
                    <tbody>
                    {
                        todos.map(
                            todo => (
                                <tr key={todo.id}>
                                    <td>{todo.id}</td>
                                    <td>{todo.description}</td>
                                    <td>{todo.done.toString()}</td>
                                    <td>{todo.targetDate.toString()}</td>
                                    <td> <button className="btn btn-warning" 
                                            onClick={() => deleteTodo(todo.id)}>Delete</button> </td>
                                    <td> <button className="btn btn-success" 
                                            onClick={() => updateTodo(todo.id)}>Update</button> </td>
                                </tr>
                            )
                        )
                    }
                    </tbody>

                </table>
            </div>
            <div className="btn btn-success m-5" onClick={addNewTodo}>Add New Todo</div>
        </div>
    )
}