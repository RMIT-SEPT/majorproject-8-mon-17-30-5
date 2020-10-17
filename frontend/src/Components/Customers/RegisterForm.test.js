import React from 'react';
import RegisterForm from './RegisterForm';
import {cleanup} from '@testing-library/react';
import ShallowRenderer from 'react-test-renderer/shallow';

afterEach(cleanup);

it("render registerForm page correctly", () =>{
    const renderer = new ShallowRenderer();
    renderer.render(<RegisterForm/>);
    const result = renderer.getRenderOutput();
    expect(result.type).toBe('div');
    expect(result.props.children).toHaveLength(8);
});