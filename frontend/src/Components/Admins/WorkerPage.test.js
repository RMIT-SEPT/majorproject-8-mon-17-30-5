import React from 'react';
import WorkerPage from './WorkerPage';
import {cleanup} from '@testing-library/react';
import ShallowRenderer from 'react-test-renderer/shallow';

afterEach(cleanup);

it("render bookings page correctly", () =>{
    const renderer = new ShallowRenderer();
    renderer.render(<WorkerPage/>);
    const result = renderer.getRenderOutput();
    expect(result.type).toBe('div');
    expect(result.props.children).toHaveLength(7);
});