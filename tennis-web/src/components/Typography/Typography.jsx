import React from "react";
import { Title } from './styles';

const Typography = (props) => {
    return <Title id={props.id}>{props.children}</Title>;
}

export default Typography;
