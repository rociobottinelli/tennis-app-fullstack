import React from "react";
import ReactDOM from "react-dom";

// Componente funcional
/*const App = () => <p>Hello world functional component</p>
ReactDOM.render(App(), document.getElementById('app'));*/

// Class component
/*class App extends React.Component{
    render() {
        return(
            <p>Hello world class component</p>
        )
    }
}

ReactDOM.render(<App/>, document.getElementById('app'));*/

// Componetizacion del componente App
import App from './components/App';
import './assets/css/app.css';
import 'bootstrap/dist/css/bootstrap.min.css';

ReactDOM.render(<App/>, document.getElementById('app'));
