import React, { useRef } from 'react';
import { Button, Form, Modal } from 'react-bootstrap';
import FormRowInput from '../FormRow/FormRowInput';
import FormRowSelect from '../FormRow/FormRowSelect';

const PartidoModal = (props) => {
  const formRef = useRef(null);
  const { show, onHide, isEdit, handleChange, partido, listaJugadores, validated, handleSubmit, errorMsg } = props;

  const jugadores = listaJugadores.map(jugador => {
    return <option key={jugador.id} value={parseInt(jugador.id)}>{jugador.nombre}</option>
  })

  return (
    <Modal
      show={show}
      onHide={onHide}
      centered={true} //Centra el modal verticalmente en la pantalla
      backdrop='static' //Si se hace click fuera del modal este no se cerrara
      keyboard={false}  //Si se presiona la tecla ESC tampoco se cierra
    >

      <Modal.Header closeButton>
        <Modal.Title>{isEdit ? 'Editar' : 'Agregar'} Partido</Modal.Title>
      </Modal.Header>

      <Modal.Body>
        <Form className={'form'} noValidate validated={validated} ref={formRef}>

          <FormRowInput
            label={'Fecha / Hora de inicio'}
            type={'text'}
            required={true}
            placeholder={'DD/MM/YYYY hh:mm'}
            value={partido.fechaComienzo}
            handleChange={handleChange}
            property={'fechaComienzo'}
          />

          <FormRowSelect
            label={"Jugador Local"}
            required={true}
            placeholder={"Elige un jugador"}
            value={partido.jugadorLocal.id}
            handleChange={handleChange}
            property={"jugadorLocal"}
            options={jugadores}
          />

          <FormRowSelect
            label={"Jugador Visitante"}
            required={true}
            placeholder={"Elige un jugador"}
            value={partido.jugadorVisitante.id}
            handleChange={handleChange}
            property={"jugadorVisitante"}
            options={jugadores}
          />

          {errorMsg !== '' &&
          <Form.Group className='alert-danger'>
            {errorMsg}
          </Form.Group>
          }
        </Form>
      </Modal.Body>

      <Modal.Footer>
        <Button onClick={onHide} variant='danger'>Cancelar</Button>
        <Button onClick={(e) => handleSubmit(e, formRef.current, isEdit)}
                variant='success'>{isEdit ? 'Editar' : 'Agregar'}</Button>
      </Modal.Footer>
    </Modal>
  );
};

export default PartidoModal;
