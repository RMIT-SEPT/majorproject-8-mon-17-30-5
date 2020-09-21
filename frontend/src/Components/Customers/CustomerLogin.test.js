import React from 'react';
import LoginForm from '../Layout/LoginForm';
import {cleanup} from '@testing-library/react';
import ShallowRenderer from 'react-test-renderer/shallow';

afterEach(cleanup);

it("render customer login correctly", () =>{
    const renderer = new ShallowRenderer();
    renderer.render(<LoginForm/>);
    const result = renderer.getRenderOutput();
    expect(result.type).toBe('div');
    expect(result.props.children).toHaveLength(5);
})
