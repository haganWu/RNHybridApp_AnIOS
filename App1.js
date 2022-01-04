import React, {Component} from 'react';
import CommonPage from './CommonPage';


export default class App1 extends Component{
    render() {
        return <CommonPage name="App1" {...this.props}/>;
    }
}
