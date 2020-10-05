import React from 'react';
import WorkerInfoBoard from './WorkerInfoBoard';
import {cleanup} from '@testing-library/react';
import ShallowRenderer from 'react-test-renderer/shallow';

afterEach(cleanup);

it("render workerInfo page correctly", () =>{
    const renderer = new ShallowRenderer();
    renderer.render(<WorkerInfoBoard/>);
    const result = renderer.getRenderOutput();
    expect(result.type).toBe('form');
    expect(result.props.children).toHaveLength(19);
});