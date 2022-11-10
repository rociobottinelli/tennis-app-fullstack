import React, {useRef} from 'react';
import {Form, Button, Modal} from 'react-bootstrap';
import FormRowInput from "../FormRow/FormRowInput";

const JugadorModal = (props) => {
    const formRef = useRef(null);
    const { show, onHide, isEdit, handleChange, jugador, validated, handleSubmit, errorMsg } = props;

    return (
        <Modal
            show={show}
            onHide={onHide}
            centered={true} //Centra el modal verticalmente en la pantalla
            backdrop="static" //Si se hace click fuera del modal este no se cerrara
            keyboard={false}  //Si se presiona la tecla ESC tampoco se cierra
        >
            <Modal.Header closeButton>
                <Modal.Title>{ isEdit ? 'Editar': 'Agregar' } Jugador</Modal.Title>
            </Modal.Header>

            <Modal.Body>
                <Form className={"form"} noValidate validated={validated} ref={formRef}>
                    <FormRowInput
                        label={'Nombre'}
                        type={'text'}
                        required={true}
                        placeholder={'Nombre del jugador'}
                        property={'nombre'}
                        value={jugador.nombre}
                        handleChange={handleChange}
                    />
                    <FormRowInput
                        label={'Puntos'}
                        type={'number'}
                        required={true}
                        placeholder={'Puntos del jugador'}
                        property={'puntos'}
                        value={jugador.puntos}
                        handleChange={handleChange}
                    />

                    {errorMsg !== '' &&
                        <Form.Group className="alert-danger">
                            {errorMsg}
                        </Form.Group>
                    }
                </Form>
            </Modal.Body>

            <Modal.Footer>
                <Button onClick={onHide} variant="danger">Cancelar</Button>
                <Button onClick={(e)=> handleSubmit(e,formRef.current, isEdit)} variant="success">{ isEdit ? 'Editar': 'Agregar' }</Button>
            </Modal.Footer>
        </Modal>
    )
}

export default JugadorModal;
