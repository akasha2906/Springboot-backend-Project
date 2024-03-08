import Form from 'react-bootstrap/Form';
import design from "./style/design.module.css"
const UserBootLogin=()=>{
    return(
        <div className={design.login}>
            <h1 style={{marginBottom:30}}>User login</h1>
            <Form>
                <Form.Group className="mb-3" controlId="formGroupEmail">
                    <Form.Label>Email address</Form.Label>
                    <Form.Control type="email" placeholder="Enter email" />
                </Form.Group>
                <Form.Group className="mb-3" controlId="formGroupPassword">
                    <Form.Label>Password</Form.Label>
                    <Form.Control type="password" placeholder="Password" />
                </Form.Group>
                <Form.Group>
                    <button className='btn btn-success mx-5 my-4'> Sign in</button>
                    <button className='btn btn-danger mx-5'> Sign Up</button>
                </Form.Group>
            </Form>
        </div>
    )

}

export default UserBootLogin