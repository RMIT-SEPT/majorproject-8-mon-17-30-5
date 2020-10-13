import React from 'react';
import WorkerDashBoard from './WorkerDashBoard';
import {cleanup} from '@testing-library/react';
import ShallowRenderer from 'react-test-renderer/shallow';

afterEach(cleanup);

it("render workerDashboard page correctly", () =>{
    const renderer = new ShallowRenderer();
    renderer.render(<WorkerDashBoard/>);
    const result = renderer.getRenderOutput();
    expect(result.type).toBe('div');
    expect(result.props.children).toHaveLength(6);
});