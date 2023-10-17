import { createContext, useContext, useState } from "react";
import { executeBasicAuthenticationService } from "../api/AuthenticationApiService";
import { apiClient } from "../api/ApiClient";


const AuthContext = createContext()
export const useAuth = () => useContext(AuthContext)


export default function AuthProvider({ children }) {

  const [token, setToken] = useState(null)
  const [isAuthenticated, setAuthenticated] = useState(false)
  const [username, setUsername] = useState(null)


  async function login(username, password) {

    const baToken = 'Basic ' + window.btoa( username + ":" + password )

    try {

        const response = await executeBasicAuthenticationService(baToken)

        if(response.status===200){
            setAuthenticated(true)
            setUsername(username)
            setToken(baToken)

            // 요청에 인증 헤더 추가하기
            apiClient.interceptors.request.use(
                (config) => {
                    console.log('intercepting and adding a token')
                    config.headers.Authorization = baToken
                    return config
                }
            )

            return true            
        } else {
            logout()
            return false
        }    
    } catch(error) {
        logout()
        return false
    }
  }

  // async function login(username, password) {

  //   try {

  //       const response = await executeJwtAuthenticationService(username, password)

  //       if(response.status===200){
            
  //           const jwtToken = 'Bearer ' + response.data.token
            
  //           setAuthenticated(true)
  //           setUsername(username)
  //           setToken(jwtToken)

  //           apiClient.interceptors.request.use(
  //               (config) => {
  //                   console.log('intercepting and adding a token')
  //                   config.headers.Authorization = jwtToken
  //                   return config
  //               }
  //           )

  //           return true            
  //       } else {
  //           logout()
  //           return false
  //       }    
  //   } catch(error) {
  //       logout()
  //       return false
  //   }
  // }

  function logout() {
    setAuthenticated(false)
    setToken(null)
    setUsername(null)
  }

  return (
    <AuthContext.Provider value={ {isAuthenticated, login, logout, username, token}  }>
        {children}
    </AuthContext.Provider>
  )
} 