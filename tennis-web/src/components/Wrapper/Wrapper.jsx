import React from 'react';
import {Col, Container, Row} from 'react-bootstrap';
import Menu from "../Menu/Menu";

const Wrapper = (props) => {
    const { children } = props;
    return (
        <>
            <Menu/>
            <Container>
                <Row>
                    <Col>
                        {children}
                    </Col>
                </Row>
            </Container>
        </>
    );
}

export default Wrapper;

