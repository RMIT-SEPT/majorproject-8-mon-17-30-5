import React from 'react';
import EditCustomer from './EditCustomer';
import {cleanup} from '@testing-library/react';
import ShallowRenderer from 'react-test-renderer/shallow';

afterEach(cleanup);

it("render editCustomer page correctly", () =>{
    const renderer = new ShallowRenderer();
    renderer.render(<EditCustomer/>);
    const result = renderer.getRenderOutput();
    expect(result.type).toBe('div');
    expect(result.props.children).toHaveLength(6);
});