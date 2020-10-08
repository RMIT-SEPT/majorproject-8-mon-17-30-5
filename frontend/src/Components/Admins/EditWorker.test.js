import React from 'react';
import EditWorker from './EditWorker';
import {cleanup} from '@testing-library/react';
import ShallowRenderer from 'react-test-renderer/shallow';

afterEach(cleanup);

it("render editWorker page correctly", () =>{
    const renderer = new ShallowRenderer();
    renderer.render(<EditWorker/>);
    const result = renderer.getRenderOutput();
    expect(result.type).toBe('div');
    expect(result.props.children).toHaveLength(6);
});