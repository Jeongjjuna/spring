import { createContext, useContext, useState } from "react";

// 1. context 생성, hook을 사용하여 노출:필요할 때 이 컨텍스트를 가져가 사용할 수 있도록 한다.
const AuthContext = createContext()
export const useAuth = () => useContext(AuthContext)

//2: Share the created context with other components
export default function AuthProvider({ children }) {
  
  //3: Put some state in the context
  const [isAuthenticated, setAuthenticated] = useState(false)
  
  const login = (username, password) => {
    if (username === 'in28minutes' && password === 'dummy') {
      setAuthenticated(true);
      return true;
    } else {
      setAuthenticated(false);
      return false;
    }
  };

  return (
      <AuthContext.Provider value={ {isAuthenticated, setAuthenticated, login} }>
          {children}
      </AuthContext.Provider>
  )
} 