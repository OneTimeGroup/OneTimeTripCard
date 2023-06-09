import React from "react";

// reactstrap components
import {
  Button,
  Card,
  CardBody,
  FormGroup,
  Form,
  Input,
  InputGroupAddon,
  InputGroupText,
  InputGroup,
  Container,
  Row,
  Col,
} from "reactstrap";

// core components
import SimpleFooter from "components/Footers/SimpleFooter.js";
import { useState } from "react";
import axios from "axios";
import Swal from "sweetalert2";

function Login(props) {
  const [inputEmail, setInputEmail] = useState("");
  const [inputPassword, setInputPassword] = useState("");

  //input 입력할때마다 이벤트 발생하여 값 받음
  const handleInputEmail = (e) => {
    setInputEmail(e.target.value);
  };
  const handleInputPassword = (e) => {
    setInputPassword(e.target.value);
  };

  const onClickLogin = (e) => {
    //기본기능을 수행하지 않음.
    e.preventDefault();

    axios({
      method: "post",
      url: "/login",
      data: {
        email: inputEmail,
        password: inputPassword,
      },
    })
      .then((res) => {
        //로그인 경우를 3가지 case로 나눔
        var email = res.data.email;

        if (email === "0") {
          // 일치하는 email 없을 경우
          Swal.fire({
            title: "Error!",
            text: "Please check your email.",
            icon: "error",
            confirmButtonText: "OK",
          });
        } else if (email === "1") {
          // password가 틀린 경우
          Swal.fire({
            title: "Error!",
            text: "Please check your password.",
            icon: "error",
            confirmButtonText: "OK",
          });
        } else {
          // sessionStorage에 id를 email이라는 key 값으로 저장
          sessionStorage.setItem("id", res.data.id);
          sessionStorage.setItem("firstName", res.data.firstName);
          sessionStorage.setItem("lastName", res.data.lastName);

          // 작업 완료 되면 페이지 이동(새로고침)
          document.location.href = "/";
        }
      })
      .catch();
  };

  return (
    <>
      <main ref={props.ref}>
        {/* 스크롤 내려가게하는거임 */}
        <section className="section section-shaped section-lg">
          {/* 파랑색 배경 */}
          <div className="shape shape-style-1 bg-gradient-default">
            <span />
            <span />
            <span />
            <span />
            <span />
            <span />
            <span />
            <span />
          </div>
          <Container className="pt-lg-7">
            {/* 안에 로그인 흰 창 위치 */}
            <Row className="justify-content-center">
              <Col lg="5">
                <Card>
                  <CardBody className="px-lg-5 py-lg-5">
                    <div style={{ textAlign: "center" }}>
                      <img
                        alt="..."
                        className=""
                        src={require("assets/img/brand/logo2.png")}
                        style={{ width: "250px" }}
                      />
                    </div>
                    <Form role="form">
                      <FormGroup className="mb-3">
                        <InputGroup className="input-group-alternative">
                          <InputGroupAddon addonType="prepend">
                            <InputGroupText>
                              <i className="ni ni-email-83" />
                            </InputGroupText>
                          </InputGroupAddon>
                          <Input
                            placeholder="Email"
                            type="email"
                            name="input_email"
                            value={inputEmail}
                            onChange={handleInputEmail}
                          />
                        </InputGroup>
                      </FormGroup>
                      <FormGroup>
                        <InputGroup className="input-group-alternative">
                          <InputGroupAddon addonType="prepend">
                            <InputGroupText>
                              <i className="ni ni-lock-circle-open" />
                            </InputGroupText>
                          </InputGroupAddon>
                          <Input
                            placeholder="Password"
                            type="password"
                            name="input_password"
                            autoComplete="off"
                            value={inputPassword}
                            onChange={handleInputPassword}
                          />
                        </InputGroup>
                      </FormGroup>
                      <div className="text-center">
                        {/* 아이디 또는 비밀번호 입력안하면 버튼 비활성화 */}
                        <Button
                          disabled={
                            inputEmail.length === 0 ||
                            inputPassword.length === 0
                          }
                          className="my-4"
                          color="primary"
                          onClick={onClickLogin}
                        >
                          Sign in
                        </Button>
                      </div>
                    </Form>
                  </CardBody>
                </Card>
                <Row className="mt-3">
                  <Col xs="6">
                    <a href="login/find-email" className="text-light">
                      <small>Forgot email / password?</small>
                    </a>
                  </Col>
                  <Col className="text-right" xs="6">
                    <a href="/login/sign-up" className="text-light">
                      <small>Create new account</small>
                    </a>
                  </Col>
                </Row>
              </Col>
            </Row>
          </Container>
        </section>
      </main>
      <SimpleFooter />
    </>
  );
}

export default Login;


