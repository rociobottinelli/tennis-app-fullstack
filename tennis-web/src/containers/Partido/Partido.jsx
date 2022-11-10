import React, { useEffect, useState } from 'react';
import Typography from '../../components/Typography/Typography';
import TablePartido from '../../components/Tables/TablePartido';
import PartidoModal from '../../components/Modals/PartidoModal';
import { Button } from 'react-bootstrap';
import httpClient from '../../lib/httpClient';

const partidoInit = {
  fechaComienzo: '',
  estado: 'NO_INICIADO',
  jugadorLocal: {
    id: -1,
  },
  jugadorVisitante: {
    id: -1,
  },
};

const dateOptions = {
  year: 'numeric',
  month: 'numeric',
  day: 'numeric',
  hour: 'numeric',
  minute: 'numeric',
  hour12: false,
};


const Partido = () => {
  const [partidosList, setPartidosList] = useState([]);
  const [listaJugadores, setListaJugadores] = useState([]);
  const [partidoData, setPartidoData] = useState(partidoInit);
  const [isEdit, setIsEdit] = useState(false);
  const [hasErrorInForm, setHasErrorInForm] = useState(false);
  const [openModal, setOpenModal] = useState(false);
  const [errorMsg, setErrorMsg] = useState('');

  useEffect(async () => {
    await getPartidos();
    await getJugadores();
  }, []);

  // Functions

  //Verbos

  const getPartidos = async () => {
    try {
      const data = await httpClient.get('/partidos');
      data.map((partido) => {
        partido.fechaComienzo = new Date (partido.fechaComienzo).toLocaleDateString('es-AR', dateOptions);
        return partido;
      });
      setPartidosList(data);
    } catch (error) {
      console.log(error);
    }
  };

  const getJugadores = async () => {
    try {
      const data = await httpClient.get('/jugadores');
      setListaJugadores(data);
    } catch (error) {
      console.log(error);
    }
  };

  const agregarPartido = async () => {
    try {
      const dataSend = {... partidoData};
      dataSend.fechaComienzo = stringToDate(dataSend.fechaComienzo);
      const data = await httpClient.post('/partidos', { data: dataSend });
      data.fechaComienzo = new Date (data.fechaComienzo).toLocaleDateString('es-AR', dateOptions);
      setPartidosList([...partidosList, data]);
    } catch (error) {
      console.log(error);
    }
    handleCloseModal();
  };

  const editarPartido = async (id) => {
    try {
      const dataSend = {...partidoData};
      dataSend.fechaComienzo = stringToDate(dataSend.fechaComienzo);
      const data = await httpClient.put(`/partidos/${id}`, { data: dataSend });
      data.fechaComienzo = new Date (data.fechaComienzo).toLocaleDateString('es-AR', dateOptions);
      setPartidosList(partidosList.map((item) => (item.id === id ? data : item)));
    } catch (error) {
      console.log(error);
    }
    handleCloseModal();
  };

  const borrarPartido = async (id) => {
    try {
      await httpClient.delete(`/partidos/${id}`, { data: partidoData });
      setPartidosList(partidosList.filter((item) => item.id !== id));
    } catch (error) {
      console.log(error);
    }
  };

  const iniciarPartido = async(id) => {
    const partido = partidosList.filter(element => element.id === id);
    if(partido[0].estado === 'NO_INICIADO'){
      try{
        await httpClient.put(`/partidos/${id}/actions/init`);
      }
      catch(error){
        console.log(error);
      }
    } 
  }


  //Usar esta funcion para convertir el string 'fechaComienzo' a Date
  const stringToDate = (dateString) => {
    try {
      const [fecha, hora] = dateString.split(' ');
      const [dd, mm, yyyy] = fecha.split('/');
      if (hora !== undefined) {
        if (hora.includes(':')) {
          const [hh, mins] = hora.split(':');
          return new Date(yyyy, mm - 1, dd, hh, mins);
        }
      }
      return new Date(yyyy, mm - 1, dd);
    } catch (err) {
      console.log(`stringToDate error formateando la fecha: ${err}`);
      return null;
    }
  };

  const validatePartido = () => {
    if (partidoData.jugadorLocal.id === partidoData.jugadorVisitante.id) {
      setErrorMsg('Los jugadores local y visitante no pueden ser iguales');
      return false;
    }

    const date = stringToDate(partidoData.fechaComienzo);

    if (!(date instanceof Date) || isNaN(date.getTime())) {
      setErrorMsg('El formato de la fecha/hora de inicio no es válido');
      return false;
    }

    if (date < new Date(Date.now())) {
      setErrorMsg('La fecha/hora de inicio debe ser mayor o igual a la fecha/hora actual');
      return false;
    }

    return true;
  };

  // Buttons
  const handleEditPartido = (editData, event) => {
    event.preventDefault();
    handleOpenModal(true, editData);
  };

  const handleDeletePartido = async (id, event) => {
    event.preventDefault();
    if (window.confirm('Estas seguro?')) {
      await borrarPartido(id);
    }
  };

  // Modal
  const handleOpenModal = (editarPartido = false, partidoToEdit = null) => {
    setIsEdit(editarPartido);

    if (editarPartido) {
      setPartidoData(partidoToEdit);
    }

    setOpenModal(true);
  };

  const handleCloseModal = () => {
    setOpenModal(false);
    setIsEdit(false);
    setHasErrorInForm(false);
    setPartidoData(partidoInit);
    setErrorMsg('');
  };

  // Form
  const handleChangeInputForm = (property, value) => {
    value === '' ? setHasErrorInForm(true) : setHasErrorInForm(false);

    const newData = { ...partidoData };

    switch (property) {
      case 'jugadorLocal':
        newData.jugadorLocal = listaJugadores.filter((x) => x.id === parseInt(value))[0];
        break;
      case 'jugadorVisitante':
        newData.jugadorVisitante = listaJugadores.filter((x) => x.id === parseInt(value))[0];
        break;
      case 'fechaComienzo':
        newData.fechaComienzo = value;
        break;
      default:
        break;
    }

    setPartidoData(newData);
  };

  const handleSubmitForm = (e, form, isEdit) => {
    e.preventDefault();
    setHasErrorInForm(true);

    if (!validatePartido()) return;

    if (form.checkValidity()) isEdit ? editarPartido(partidoData.id) : agregarPartido();
  };

  return (
    <>
      <Typography id={'title-id'}>Partido</Typography>
      <div className='mb-2'>
        <Button variant='success' onClick={() => handleOpenModal()}>Agregar partido</Button>
      </div>
      <TablePartido
        dataForTable={partidosList}
        editPartido={handleEditPartido}
        deletePartido={(id, event) => handleDeletePartido(id, event)}
        iniciarPartido={iniciarPartido}
      />
      <PartidoModal
        show={openModal}
        onHide={handleCloseModal}
        isEdit={isEdit}
        handleChange={handleChangeInputForm}
        validated={hasErrorInForm}
        handleSubmit={handleSubmitForm}
        errorMsg={errorMsg}
        partido={partidoData}
        listaJugadores={listaJugadores}
      />
    </>
  );
};

export default Partido;
