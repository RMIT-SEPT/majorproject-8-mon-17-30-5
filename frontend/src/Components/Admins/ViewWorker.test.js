import React from 'react';
import ViewWorker from './ViewWorker';
import {cleanup} from '@testing-library/react';
import ShallowRenderer from 'react-test-renderer/shallow';

afterEach(cleanup);

it("render viewWorker page correctly", () =>{
    const renderer = new ShallowRenderer();
    renderer.render(<ViewWorker/>);
    const result = renderer.getRenderOutput();
    expect(result.type).toBe('div');
    expect(result.props.children).toHaveLength(7);
});