import React from 'react';
import CustomerBooking from './CustomerBooking';
import {cleanup} from '@testing-library/react';
import ShallowRenderer from 'react-test-renderer/shallow';

afterEach(cleanup);

it("render customerBooking page correctly", () =>{
    const renderer = new ShallowRenderer();
    renderer.render(<CustomerBooking/>);
    const result = renderer.getRenderOutput();
    expect(result.type).toBe('div');
    expect(result.props.children).toHaveLength(3);
});