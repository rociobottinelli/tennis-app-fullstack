import React from 'react';
import { BrowserRouter, Route, Switch } from 'react-router-dom';

import Wrapper from './Wrapper/Wrapper';
import Home from '../containers/Home/Home';
import Jugador from '../containers/Jugador/Jugador';
import Detalle from '../containers/Jugador/Detalle';
import Partido from '../containers/Partido/Partido';
import JugarPartido from '../containers/JugarPartido/JugarPartido';
import About from '../containers/About/About';
import NotFound from '../containers/NotFound/NotFound';

class App extends React.Component {
  render() {
    return (
      <>
        <BrowserRouter>
          <Wrapper>
            <Switch>
              <Route exact path="/" component={Home} />
              <Route exact path="/jugador" component={Jugador} />
              <Route exact path="/jugador/detalle/:id" component={Detalle} />
              <Route exact path="/partido" component={Partido} />
              <Route exact path="/partido/jugar-partido" component={JugarPartido} />
              <Route exact path="/about" component={About} />
              <Route component={NotFound} />
            </Switch>
          </Wrapper>
        </BrowserRouter>
      </>
    );
  }
}

export default App;
