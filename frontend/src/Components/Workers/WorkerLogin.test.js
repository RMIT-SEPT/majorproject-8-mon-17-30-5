import React from 'react';
import WorkerLogin from './WorkerLogin';
import {cleanup} from '@testing-library/react';
import ShallowRenderer from 'react-test-renderer/shallow';

afterEach(cleanup);

it("render worker login correctly", () =>{
    const renderer = new ShallowRenderer();
    renderer.render(<WorkerLogin/>);
    const result = renderer.getRenderOutput();
    expect(result.type).toBe('div');
    expect(result.props.children).toHaveLength(5);
});
