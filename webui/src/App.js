import React from 'react';
import './App.css';

class App extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            pokedex: null
        };
    }

    componentDidMount() {
        // Simple GET request using fetch
        fetch('https://pokedex-server-lyaweuqqfq-ew.a.run.app/')
            .then(response => response.text())
            .then(data => this.setState({ pokedex: data }));
    }

  render() {
   return <div className="App">
        Pokedex: { this.state.pokedex }
    </div>
  }
}

export default App;
